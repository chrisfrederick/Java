package com.chrisfrederick.spotifyapp.controllers;

import com.chrisfrederick.spotifyapp.config.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class AuthController {

    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/api/get-user-code/");
    private String code = "";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("0ed9c85dda2345f1bd49ac678640ffda")
            .setClientSecret("195bcea0eed045b6ac3e874337a7bd14")
            .setRedirectUri(redirectUri)
            .build();


    @GetMapping("login")
    @ResponseBody
    public String spotifyLogin(){
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope("user-read-private, user-read-email, user-top-read")
                .show_dialog(true)
                .build();
        final URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }
}
