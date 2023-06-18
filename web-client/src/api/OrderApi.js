import {developmentModeOn} from "./developmentMode.js";
import {fakeFetch} from "./fakeApi/fakeFetch.js";
import fakeCreateResponse from '../assets/fakeResponses/post_api_customers_id_orders.json';
import fakeGetResponse from '../assets/fakeResponses/get_api_customers_id_orders.json';
import fakeAddProductResponse from '../assets/fakeResponses/post_api_orders_id_products.json';


class OrderApi {
    createOrder(customerId, order) {
        return developmentModeOn ?
            fakeFetch(fakeCreateResponse) :
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
        return developmentModeOn ?
            fakeFetch(fakeGetResponse) :
            fetch(`/api/customers/${customerId}/orders`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Unable to create order!")
                    }
                    return response.json();
                })
    }

    addProduct(orderId, productId) {
        return developmentModeOn ?
            fakeFetch(fakeAddProductResponse) :
            fetch(`/api/orders/${orderId}/products?productId=${productId}`,
                {method: 'POST'})
    }
}

export default OrderApi;