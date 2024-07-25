
---

# 📊 GraphQLLogement with Spring Boot

Welcome to the **GraphQLLogement** project! This repository demonstrates how to create a GraphQL API using Spring Boot to manage real estate properties (`Logement`) and appointments (`RendezVous`). This guide provides a detailed overview of the project structure, including entities, GraphQL schema, and repositories.

## 🚀 Getting Started

To get started with the **GraphQLLogement** project, follow these steps:

### 1. Clone the Repository

```bash
git clone https://github.com/firasabdelaziz/GraphQLLogement.git
cd GraphQLLogement
```

### 2. Build and Run

Ensure you have Java and Maven installed. Run the following command to build and start the application:

```bash
mvn clean install
mvn spring-boot:run
```

## 📂 Project Structure

Here's an overview of the project's structure:

- **`entite/`**: Contains entity classes for `Logement` and `RendezVous`.
- **`graphql/`**: Contains GraphQL resolvers and the GraphQL endpoint configuration.
- **`repository/`**: Contains repository classes for data management.
- **`schema.graphqls`**: Defines the GraphQL schema.

### Entities

#### `Logement`

- **Fields**:
  - `reference`: Unique identifier (int)
  - `adresse`: Address (String)
  - `delegation`: Delegation area (String)
  - `gouvernorat`: Governorate (String)
  - `type`: Type of property (Enum)
  - `description`: Description of property (String)
  - `prix`: Price (float)

#### `RendezVous`

- **Fields**:
  - `id`: Unique identifier (int)
  - `date`: Date of the appointment (String)
  - `heure`: Time of the appointment (String)
  - `logement`: Associated `Logement` (Logement)
  - `numTel`: Contact number (String)

## 🔍 GraphQL Schema

The GraphQL schema is defined in `schema.graphqls` and includes types, queries, and mutations:

### Types

#### `Logement`

```graphql
type Logement {
    reference: Int
    adresse: String
    delegation: String
    gouvernorat: String
    type: Type
    description: String
    prix: Float
}
```

#### `RendezVous`

```graphql
type RendezVous {
    id: Int
    date: String
    heure: String
    logement: Logement
    numTel: String
}
```

#### `Type` Enum

```graphql
enum Type {
    Studio
    Appartement
    Villa
    EtageVilla
}
```

### Queries

```graphql
type Query {
    getAllRdv: [RendezVous]
    getAllLogement: [Logement]
    getRdvbyId(id: Int): RendezVous
    getLogementbyRef(ref: Int): Logement
}
```

### Mutations

```graphql
type Mutation {
    createRendezVous(
        id: Int,
        date: String,
        heure: String,
        refLog: Int,
        num: String
    ): [RendezVous]

    updateRendezVous(
        id: Int,
        date: String,
        heure: String,
        numTel: String
    ): Boolean

    createLogement(
        reference: Int,
        adresse: String
    ): Logement
}
```

## 🛠️ Configuration

### GraphQL Endpoint

The GraphQL endpoint is configured in `GraphQlEndPoint.java` and exposed at `/graphql`. It uses `SchemaParser` to build the GraphQL schema and integrates with the resolvers (`Query` and `Mutation`).

### Repositories

- **`LogementRepository`**: Manages `Logement` data.
- **`RendezVousRepository`**: Manages `RendezVous` data.

## 💡 Usage

### Query Examples

1. **Get All Appointments**

   ```graphql
   query {
       getAllRdv {
           id
           date
           heure
           logement {
               reference
               adresse
           }
           numTel
       }
   }
   ```

2. **Get Logement by Reference**

   ```graphql
   query {
       getLogementbyRef(ref: 1) {
           reference
           adresse
           prix
       }
   }
   ```

### Mutation Examples

1. **Create a New RendezVous**

   ```graphql
   mutation {
       createRendezVous(
           id: 4,
           date: "01-01-2024",
           heure: "10:00",
           refLog: 2,
           num: "12345678"
       ) {
           id
           date
           heure
           logement {
               reference
               adresse
           }
           numTel
       }
   }
   ```

2. **Update an Existing RendezVous**

   ```graphql
   mutation {
       updateRendezVous(
           id: 1,
           date: "02-02-2024",
           heure: "11:00",
           numTel: "87654321"
       )
   }
   ```

## 🔗 Resources

- **[GraphQL Documentation](https://graphql.org/learn/)**
- **[Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)**
- **[Maven Documentation](https://maven.apache.org/guides/index.html)**

## 🤝 Contributing

Feel free to contribute to this project by submitting issues or pull requests. Please ensure that your contributions adhere to the project's coding standards and include appropriate tests.

## 📝 License

This project is licensed under the [MIT License](LICENSE).

---