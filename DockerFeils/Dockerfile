# Bruk en offisiell Java-runtime
FROM openjdk:17

# Sett arbeidskatalog i containeren
WORKDIR /app

# Kopier alt inn i containeren
COPY . .

# Kompiler Java-koden
RUN javac Server.java

# Start serveren
CMD ["java", "Server"]
