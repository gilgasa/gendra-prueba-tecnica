# Gendra Technical Test Project

![Java CI with Maven](https://github.com/gilgasa/gendra-prueba-tecnica/workflows/Java%20CI%20with%20Maven/badge.svg)

This project was developed as a technical test for Gendra. It leverages various technologies, tools, and platforms to deliver a comprehensive Spring Boot application. 

## **Technologies & Tools:**

- **Java**: The core language used for the development. Specifically, Java 8.
- **Spring Boot**: Used as the foundation framework to create stand-alone, production-grade Spring-based applications with minimal fuss.
- **Maven**: Dependency management and project building tool. Two profiles are used - default for general Maven compilation and another specifically tailored for Docker.
- **Docker**: Application is containerized using Docker, adhering to modern deployment methodologies.
- **Lombok**: Used to reduce boilerplate code for model/data objects. It provides annotations to automatically generate getters, setters, builders, and more.
- **Swagger**: API documentation and testing tool. The project uses OpenAPI 3 specifications. 
- **H2 Database**: An in-memory database used for the application.
- **GitHub Actions**: Automated CI/CD workflow. Upon pushing to the master branch, the project gets automatically built, containerized, and deployed to Google Cloud.
- **Google Cloud**: The application is hosted on Google Cloud Platform, specifically using the Google Cloud Run and Google Container Registry services.

## **Workflow:**

Whenever a push is made to the master branch:

1. GitHub Actions workflow triggers.
2. Code is checked out, and Java 8 environment is set.
3. The application is built using Maven.
4. Docker image of the application is created and pushed to Google Container Registry.
5. The image is deployed to Google Cloud Run.

## **API Documentation:**

The API documentation is facilitated by Swagger. To view or test the endpoints, visit:

- [Swagger UI](https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app/swagger-ui/index.html)
- [API Docs](https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app/v3/api-docs)

### **Endpoints:**

1. **GET Suggestions**:
    Retrieve suggestions based on query:
   [https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app:443/suggestions?q=londo](https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app:443/suggestions?q=londo)
   
   Or with latitude and longitude:
   [https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app:443/suggestions?q=Londo&latitude=42.98339&longitude=-81.23304](https://gendra-prueba-tecnica-gil-aqabzhnqjq-uc.a.run.app:443/suggestions?q=Londo&latitude=42.98339&longitude=-81.23304)

## **Building & Running:**

### **With Maven (Default Profile):**

1. Clone the repository.
2. Navigate to the project root directory.
3. Execute the following:
```bash
mvn clean install
```

### **With Docker:**
1. Ensure Docker is running.
2. Navigate to the project root directory.
3. Execute the following:
```bash
mvn clean package -Pcompilar-docker
```

### **Contributions & Feedback:**

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.