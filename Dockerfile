FROM eclipse-temurin:21-jdk-alpine

# Install Node.js and npm
RUN apk add --no-cache nodejs npm

# Set working directory
WORKDIR /app

# Copy package files
COPY package*.json ./

# Install dependencies
RUN npm ci

# Copy project files
COPY . .

# Build the application
RUN npm run build

# Expose port (if needed for preview, though this is a static site)
EXPOSE 8080

# For static hosting, we just need the public directory
# The hosting platform will serve from /app/public