package com.shoppin.app.controller.Dto;

public record ResponseDto<T>(String message, T data) {

}
