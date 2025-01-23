#!/bin/bash

# Danh sách các service
SERVICES=("APIGateWay" "user-service" "course-service" "chat-service" "enroll-service")

# Kiểm tra tham số dòng lệnh
if [ "$#" -eq 0 ]; then
  # Nếu không có tham số, build tất cả các service
  echo "No service specified. Building all services..."
  SERVICES_TO_BUILD=("${SERVICES[@]}")
else
  # Nếu có tham số, chỉ build các service được chỉ định
  SERVICES_TO_BUILD=()
  for INPUT_SERVICE in "$@"; do
    # Kiểm tra xem INPUT_SERVICE có trong danh sách SERVICES không
    VALID_SERVICE=false
    for SERVICE in "${SERVICES[@]}"; do
      if [ "$INPUT_SERVICE" == "$SERVICE" ]; then
        VALID_SERVICE=true
        break
      fi
    done

    if [ "$VALID_SERVICE" == true ]; then
      SERVICES_TO_BUILD+=("$INPUT_SERVICE")
    else
      echo "Service '$INPUT_SERVICE' không tồn tại trong danh sách. Bỏ qua."
    fi
  done

  # Nếu không có service nào hợp lệ, thoát
  if [ "${#SERVICES_TO_BUILD[@]}" -eq 0 ]; then
    echo "No valid services specified. Exiting."
    exit 1
  fi
fi

# Lặp qua các service cần build
for SERVICE in "${SERVICES_TO_BUILD[@]}"; do
  echo "Building $SERVICE..."

  if [ -f "$SERVICE/pom.xml" ]; then
    (cd "$SERVICE" && mvn clean install "-Dmaven.build=true")
    if [ $? -ne 0 ]; then
      echo "Build failed for $SERVICE. Exiting."
      exit 1
    else
      echo "$SERVICE built successfully."
    fi
  else
    echo "No pom.xml found in $SERVICE. Skipping."
  fi
done

echo "All specified services built successfully."
