import {developmentModeOn} from "./developmentMode.js";
import fakeData from "../assets/fakeOrder.json"

function fakeCreateOrder() {
    return Promise.resolve(fakeData);
}

function fakeGetOrders() {
    return Promise.resolve([fakeData]);
}

class OrderApi {
    createOrder(order) {
        return developmentModeOn? fakeCreateOrder() : fetch("/api/orders",
            {
                method: 'POST',
                body: JSON.stringify(order)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Unable to create order!")
                }
                return response.json();
            })
    }

    getOrders() {
        return developmentModeOn? fakeGetOrders() : fetch("/api/orders")
            .then(response =>{
                if (!response.ok) {
                    throw new Error("Unable to create order!")
                }
                return response.json();
            })
    }
}

export default OrderApi;