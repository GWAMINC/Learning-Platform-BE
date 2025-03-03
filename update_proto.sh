#!/bin/bash

# 1. Lấy danh sách file .proto bị thay đổi
echo "Detecting modified .proto files..."
#MODIFIED_PROTO_FILES=$(git diff --name-only HEAD~1 | grep '\.proto')
MODIFIED_PROTO_FILES=$(git diff --name-only --staged | grep '\.proto')

if [ -z "$MODIFIED_PROTO_FILES" ]; then
  echo "No .proto files changed. Exiting."
  exit 0
fi

echo "Modified .proto files:"
echo "$MODIFIED_PROTO_FILES"

GRPC_PLUGIN=$(find "$USERPROFILE/Downloads" -name 'protoc-gen-grpc-java-*.exe' | head -n 1)

if [ -z "$GRPC_PLUGIN" ]; then
  echo "Error: protoc-gen-grpc-java not found in Downloads folder. Please download it first."
  exit 1
fi

echo "Using gRPC plugin: $GRPC_PLUGIN"


# 2. Kiểm tra từng service xem có phụ thuộc vào file nào trong số các file bị thay đổi
SERVICES=("APIGateWay" "user-service" "course-service" "chat-service" "enroll-service")
for SERVICE in "${SERVICES[@]}"; do
  echo "Checking $SERVICE dependencies..."
  if [ ! -f "$SERVICE/proto-dependencies.txt" ]; then
    echo "No proto-dependencies.txt found in $SERVICE. Skipping."
    continue
  fi

  # Kiểm tra xem service này có sử dụng file nào trong các file thay đổi không
  for PROTO_FILE in $MODIFIED_PROTO_FILES; do
    if grep -q "$PROTO_FILE" "$SERVICE/proto-dependencies.txt"; then
      echo "Generating code for $PROTO_FILE in $SERVICE..."
      protoc --proto_path=proto --java_out="$SERVICE/src/main/java" "$PROTO_FILE"
      protoc --proto_path=proto --java_out="$SERVICE/src/main/java" --grpc-java_out="$SERVICE/src/main/java" --plugin=protoc-gen-grpc-java="$GRPC_PLUGIN" "$PROTO_FILE"

      echo "Replacing javax.annotation.Generated with jakarta.annotation.Generated in $SERVICE..."
      find "$SERVICE/src/main/java" -type f -name "*.java" -exec sed -i 's/javax\.annotation\.Generated/jakarta.annotation.Generated/g' {} +

      echo "Building $SERVICE..."
      (cd "$SERVICE" && mvn clean install "-Dmaven.build=true")
    fi
  done
done
