package org.example.myapp.service;

public class Variable { // 클래스영역
    // 멤버변수

    int a = 0; // 인스턴스 변수, 생성시기:인스턴스가 생성될 떄
    static int b = 0; // 클래스변수 (static 변수, 공유변수), 생성시기:클래스가 메모리에 올라갈 때. 인스턴스를 생성하지 않고도 언제든지 사용할 수 있다. 클래스 변수는 클래스가 메모리에 로딩될 때 생성되어 프로그램이 종료될때까지 유지된다.

    public void method() { // 메서드 영역
        int a = 0; // 지역변수 (local variable), 생성시기:변수선언문이 수행될 때. 메서드 내에 선언되어 메서드 내에서만 사용가능하며 메서드가 종료되면 소멸되어 사용할 수 없다.
    }
}
