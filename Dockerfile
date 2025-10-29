FROM eclipse-temurin:23-jdk

WORKDIR /app

COPY . /app

RUN mkdir -p out && javac -encoding UTF-8 -d out $(find src -name "*.java")

COPY inicio.sh .

RUN chmod +x inicio.sh
CMD ["./inicio.sh"]
