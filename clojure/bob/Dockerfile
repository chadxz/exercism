FROM clojure
RUN echo "{:user {:plugins [[lein-exec \"0.3.1\"]]}}" >> ~/.lein/profiles.clj
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
CMD lein exec bob_test.clj
