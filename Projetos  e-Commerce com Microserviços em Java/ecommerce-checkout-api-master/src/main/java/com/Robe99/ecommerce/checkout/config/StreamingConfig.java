package com.Robe99.ecommerce.checkout.config;

import com.Robe99.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = 
{
        CheckoutCreatedSource.class,
//        PaymentPaidSink.class
})
public class StreamingConfig 
{
        
}
