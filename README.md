# Extended official documentation - [aws lambda http](https://quarkus.io/guides/aws-lambda-http)

## Prerequisites
- JDK 21
- Apache Maven
- Quarkus CLI
- GraalVM and Working C environment - [see](https://quarkus.io/guides/building-native-image#configuring-c-development) (optional)
- AWS SAM CLI

## Build native image

### With GraalVM (faster)
`quarkus build --native --no-tests`

### Without GraalVM
`quarkus build --native --no-tests -Dquarkus.native.container-build=true`

## Deploy to the AWS Cloud using AWS CloudFormation
`sam deploy -t sam.native-arm64.yaml`

## My Experiences

Building and deploying native image with **Qaurkus** is way easier and faster than **Spring** ecosystem. Losing out on the Spring libraries pays with performance.

**Spring** native image build took around **30 mins** (there is definitely another problem). But **Quarkus** only took **1.4 mins** with **GraalVM**, and **3.20 mins** without GraalVM.

Configuration took much less time and energy.

Although I am much more familiar with **Spring** ecosystem, I will give **Quarkus** a chance.
