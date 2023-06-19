# SuperStore

A project built with Kotlin, SpringBoot, and Svelte.

## How to start

### Run locally (Frontend+Backend)

#### Database
The application requires a postgress database running on port 5432. See `src/main/resources/application.properties` for 
details.`

To run this project locally, use the project's Gradle Wrapper:

```
./gradlew bootRun
```

Note this will compile both the API and the Svelte client in a single command.

### Run frontend only (development mode)

From within the `web-client` folder, run the `npm install` command to install dependencies and then `npm run dev`.

## SuperStore API

| Method | Path                         | Description                                      |
|--------|------------------------------|--------------------------------------------------|
| GET    | `/api/products`              | Returns all products in the store                |
| GET    | `/api/customers/{id}`        | Returns customer data (name, shipping info, etc) |
| POST   | `/api/customers/{id}/orders` | Creates a new order for a customer               |
| POST   | `/api/orders/{id}/products`  | Adds a product to an existing order              |
| GET    | `/api/customers/{id}/orders` | Returns all customer's orders                    |

## References

The product data is taken from `https://dummyjson.com/products`

### Fix

- Description in database undefined