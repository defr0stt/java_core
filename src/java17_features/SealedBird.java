package java17_features;

// Запечатанные (sealed) типы — это классы или интерфейсы,
// которые накладывают ограничения на другие классы или интерфейсы,
// которые могут расширять или реализовывать их.
//
// Для объявления sealed класса или интерфейса используется sealed модификатор.
// Список подтипов может быть перечислено во времени объявления sealed класса или интерфейса
// после ключевого слова permits. В случае если подтипы находятся в том же пакете или
// модуле, то компилятор сам может вывести список подтипов и permits в объявлении sealed
// класса или интерфейса можно опустить.


// permits - розрешает наследование определённым класам
public sealed interface SealedBird permits Duck,Penguin{
    public String noise();
    public SealedBird bird();
}

// должен быть sealed, final или non-sealed
sealed interface Duck extends SealedBird{
    @Override
    default Duck bird(){
        return new Mallard();
    }
}
sealed interface Penguin extends SealedBird{
    @Override
    default Penguin bird(){
        return new EmperorPenguin();
    }
}

// sealed interface должен иметь минимум 1 наследника (клас или интерфейс)
final class EmperorPenguin implements Penguin{
    @Override
    public String noise() {
        return "*ice crashing*";
    }
}

// должен быть sealed, final или non-sealed
// non-sealed = неограниченое количество наследников (0 включительно)
non-sealed class Mallard implements Duck{
    @Override
    public String noise() {
        return "quack";
    }
}