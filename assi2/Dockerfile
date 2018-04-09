FROM java:8

RUN apt-get update \
    && apt-get install maven -y

WORKDIR /app
COPY . .

ENTRYPOINT ["/bin/bash"]
CMD ["entrypoint.sh"]
