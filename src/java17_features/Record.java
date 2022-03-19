package java17_features;

// Записи (record) предоставляют лаконичный синтаксис для объявления
// классов, которые являются простыми носителями постоянных,
// неизменяемых наборов данных.

import java.util.UUID;
// UUID - клас для обозначения уникальных идентификаторов

// + может расширять интерфейсы
// - не может наследовать класы
// - final по дефолту так, как и их значения
public record Record(UUID uuid, String name, int price){
    // главный конструктор
    public Record(UUID uuid, String name, int price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }
    // при вызове расширяющих констркуторов
    // должен обязательно вызываться главный конструктор
}