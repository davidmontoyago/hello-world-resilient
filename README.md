# Resilient Hello World app with Hystrix

### Run me
```sh
./gradlew bootRun
```

### Demo me
```sh
for num in $(seq 1 1000); do curl "http://localhost:8080" ; done
```

### Home
http://localhost:8080

### Hystrix Dashboard

http://localhost:8080/hystrix
