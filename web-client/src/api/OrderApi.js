import {developmentModeOn} from "./developmentMode.js";

function fakeCreateOrder() {
    return Promise.resolve({ id: 7234});
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
}

export default OrderApi;