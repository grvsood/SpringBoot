package com.sapient.parkingsystem.contants;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import lombok.NonNull;

public final class ParkingConstants {

    private ParkingConstants() {

    }

    public enum RecurringPeriod {
        WEEKLY("WEEKLY"),
        MONTHLY("MONTHLY"),
        DAILY("DAILY"),
        NONE("NONE");

        @Getter
        private final String recurringPeriod;

        RecurringPeriod(@NonNull final String recurringPeriod) {

            this.recurringPeriod = recurringPeriod;
        }

        @JsonCreator
        public static RecurringPeriod fromValue(@NonNull final String recurringPeriod) {

            return Arrays.stream(RecurringPeriod.values()).filter(m -> m.recurringPeriod.equals(recurringPeriod))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("UnSupportedTypeFormat" + recurringPeriod));
        }

    }

    public enum Response {
        SUCCESS("Success"),
        ERROR("Error");

        @Getter
        private final String response;

        Response(@NonNull final String response) {

            this.response = response;
        }
    }
}
