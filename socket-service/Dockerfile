# Sử dụng Node.js phiên bản mới nhất LTS
FROM node:18

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt dependencies
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Expose cổng 5001 để nhận kết nối WebSocket
EXPOSE 5001

# Chạy server
CMD ["node", "server.js"]
