export class CustomerApi {
    getCustomerInfo(customerId) {
        return fetch(`/api/customers/${customerId}`)
            .then(response => response.json())
    }
}