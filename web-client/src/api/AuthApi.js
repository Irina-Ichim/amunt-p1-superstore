import {currentUser, loggedIn} from "../store/session.js";
import {developmentModeOn} from "./developmentMode.js";
import {fakeFetch} from "./fakeApi/fakeFetch.js";
import fakeResponse from '../assets/fakeResponses/get_api_auth_login.json';

function logInUser(name, id) {
    loggedIn.update(_ => true);
    currentUser.update(_ => {
        return {
            name,
            id
        }
    })

}

export class AuthApi {
    login(username, password) {
        return (
            developmentModeOn ?
                fakeFetch(fakeResponse) :
                this.loginWithAuthApi(username, password))
            .then(loginInfo => {
                let {name, id} = loginInfo
                logInUser(name, id);
            })
            .catch(err => console.log(err))
    }

    loginWithAuthApi(username, password) {
        return fetch("/api/auth/login", {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({username, password})
        }).then(response => {
            if (!response.ok) {
                throw new Error("Unable to login");
            }
            return response.json()
        });
    }
}