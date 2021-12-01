package com.company;

public interface HIPAAComplaintUser {
        abstract boolean assignPin(int pin);
        abstract boolean accessAuthorized(Integer confirmedAuthID);
}
