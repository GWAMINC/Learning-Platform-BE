#!/bin/bash

# Danh sách các service
SERVICES=("APIGateWay" "user-service" "course-service" "chat-service" "enroll-service")

# Lặp qua từng service và chạy mvn clean install
for SERVICE in "${SERVICES[@]}"; do
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

echo "All services built successfully."
