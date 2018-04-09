# Assignment 2

#### Start development container
```bash
docker build -t mutation .
```

#### Run tests
```bash
# Test results only
docker run -it --rm mutation

# Get HTML report
docker run -it --rm \
    -v "$(pwd)":/app \
mutation
```
