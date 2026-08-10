package com.sonar.demo;

public record Order(long id, String ownerId, String item, int quantity) {}
