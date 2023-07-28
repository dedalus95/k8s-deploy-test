### STAGE 1: Build ###
FROM node:18.10-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install -g npm@8.19.3
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.21.0-alpine
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/* /usr/share/nginx/html
# Expose port 4200
EXPOSE 4200
# When the container starts, replace the env.js with values from environment variables
CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env.template.js > /usr/share/nginx/html/assets/env.js && exec nginx -g 'daemon off;'"]
