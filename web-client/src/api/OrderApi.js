import {developmentModeOn} from "./developmentMode.js";
import fakeData from "../assets/fakeOrder.json"

function fakeCreateOrder() {
    return Promise.resolve(fakeData);
}

function fakeGetOrders() {
    return Promise.resolve([fakeData]);
}

class OrderApi {
    createOrder(customerId, order) {
        return developmentModeOn ? fakeCreateOrder() :
            fetch(`/api/customers/${customerId}/orders`,
                {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(order)
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Unable to create order!")
                    }
                    return response.json();
                })
    }

    getOrders(customerId) {
        return developmentModeOn ? fakeGetOrders() :
            fetch(`/api/customers/${customerId}/orders`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Unable to create order!")
                    }
                    return response.json();
                })
    }

    addProduct(orderId, productId) {
        return fetch(`/api/orders/${orderId}/products?productId=${productId}`,
            {method: 'POST'})
    }
}

export default OrderApi;