import {developmentModeOn} from "./developmentMode.js";
import {fakeFetch} from "./fakeApi/fakeFetch.js";
import fakeResponse from '../assets/fakeResponses/get_api_customers_id.json';

export class CustomerApi {
    getCustomerInfo(customerId) {
        return developmentModeOn ?
            fakeFetch(fakeResponse) :
            fetch(`/api/customers/${customerId}`)
                .then(response => response.json())
    }
}