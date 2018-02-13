# Assignment
Assignments for CA650 Software Process Quality

#### Start development container
```bash
docker run -it --rm \
    -v "$PWD":/app \
    -w /app \
java:8 bash
```

#### Run tests
```bash
bash run_tests.sh
```
