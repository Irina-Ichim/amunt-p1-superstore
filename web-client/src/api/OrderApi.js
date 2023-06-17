import {developmentModeOn} from "./developmentMode.js";
import fakeData from "../assets/fakeOrder.json"
import {currentUser} from "../store/session.js";

function fakeCreateOrder() {
    return Promise.resolve(fakeData);
}

function fakeGetOrders() {
    return Promise.resolve([fakeData]);
}

class OrderApi {
    createOrder(customerId, order) {
        return developmentModeOn? fakeCreateOrder() :
            fetch(`/api/customers/${customerId}/orders`,
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

    getOrders(customerId) {
        return developmentModeOn? fakeGetOrders() :
            fetch(`/api/customers/${customerId}/orders`)
            .then(response =>{
                if (!response.ok) {
                    throw new Error("Unable to create order!")
                }
                return response.json();
            })
    }
}

export default OrderApi;