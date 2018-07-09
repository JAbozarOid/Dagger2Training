package com.example.daggersample.daggersample;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {UserModule.class}) // کار component ارتباط دادن وابستگی‌ها و فراهم کننده‌هاست هست. برای این کار نیاز داریم فراهم کننده‌ها رو به component بشناسونیم.
public interface UserComponent {

    User provideUser(); // زیبایی کار اینجاست که userـی که توسط این متد برامون فراهم میشه تمام وابستگی‌هاش به طور خودکار تامین خواهد شد.

}
