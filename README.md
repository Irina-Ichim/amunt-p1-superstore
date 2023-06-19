# SuperStore

A project built with Kotlin, SpringBoot, and Svelte.

## How to start

### Run locally (Frontend+Backend)

To run this project locally, use the project's Gradle Wrapper:

```
./gradlew bootRun
```

Note this will compile both the API and the Svelte client in a single command.

### Run frontend only (development mode)

From within the `web-client` folder, run the `npm install` command to install dependencies and then `npm run dev`.

## SuperStore API

| Method | Path                         | Description                                      | Secured? | Implemented? |
|--------|------------------------------|--------------------------------------------------|----------|--------------|
| GET    | `/api/products`              | Returns all products in the store                | No       | ✅            |
| GET    | `/api/customers/{id}`        | Returns customer data (name, shipping info, etc) | Yes      | ✅            |
| POST   | `/api/customers/{id}/orders` | Creates a new order for a customer               | Yes      | ❌            |
| POST   | `/api/orders/{id}/products`  | Adds a product to an existing order              | Yes      | ❌            |
| GET    | `/api/customers/{id}/orders` | Returns all customer's orders                    | Yes      | ❌            |

## References

The product data is taken from `https://dummyjson.com/products`