#!/bin/bash

# Kiểm tra xem thư mục proto có tồn tại không
if [ ! -d "proto" ]; then
  echo "Error: proto directory not found. Exiting."
  exit 1
fi

# Tìm plugin gRPC
GRPC_PLUGIN=$(find "$USERPROFILE/Downloads" -name 'protoc-gen-grpc-java-*.exe' | head -n 1)

if [ -z "$GRPC_PLUGIN" ]; then
  echo "Error: protoc-gen-grpc-java not found in Downloads folder. Please download it first."
  exit 1
fi

# Danh sách các service
SERVICES=("APIGateWay" "user-service" "course-service" "chat-service" "enroll-service")

# Nếu có tham số, chỉ build file proto được chỉ định
if [ -n "$1" ]; then
  PROTO_FILES=("proto/$1")
  if [ ! -f "proto/$1" ]; then
    echo "Error: proto file $1 not found. Exiting."
    exit 1
  fi
else
  # Nếu không có tham số, build tất cả các file proto
  readarray -t PROTO_FILES < <(find proto -name '*.proto')
fi

if [ ${#PROTO_FILES[@]} -eq 0 ]; then
  echo "No .proto files found. Exiting."
  exit 0
fi

for SERVICE in "${SERVICES[@]}"; do
  if [ ! -f "$SERVICE/proto-dependencies.txt" ]; then
    echo "No proto-dependencies.txt found in $SERVICE. Skipping."
    continue
  fi

  SERVICE_PROTO_FILES=()

  for PROTO_FILE in "${PROTO_FILES[@]}"; do
    if grep -q "$(basename "$PROTO_FILE")" "$SERVICE/proto-dependencies.txt"; then
      SERVICE_PROTO_FILES+=("$PROTO_FILE")
    fi
  done

  if [ ${#SERVICE_PROTO_FILES[@]} -gt 0 ]; then
    echo "Generating code for ${SERVICE_PROTO_FILES[@]} in $SERVICE..."
    for PROTO_FILE in "${SERVICE_PROTO_FILES[@]}"; do
      protoc --proto_path=proto --java_out="$SERVICE/src/main/java" "$PROTO_FILE"
      protoc --proto_path=proto --java_out="$SERVICE/src/main/java" --grpc-java_out="$SERVICE/src/main/java" --plugin=protoc-gen-grpc-java="$GRPC_PLUGIN" "$PROTO_FILE"

      GENERATED_FILES=$(find "$SERVICE/src/main/java" -type f -name "*.java" -newer "$PROTO_FILE")
      if [ -n "$GENERATED_FILES" ]; then
        echo "Replacing javax.annotation.Generated with jakarta.annotation.Generated in generated files..."
        for FILE in $GENERATED_FILES; do
          sed -i 's/javax\.annotation\.Generated/jakarta.annotation.Generated/g' "$FILE"
        done
      fi
    done

    echo "Building $SERVICE..."
    (cd "$SERVICE" && mvn clean install "-Dmaven.build=true")
  fi
done

echo "Proto files regenerated successfully."
