//객체, 객체를 함수의 인자로 넘길 경우
let obj1={"name":"lee","addr":"seoul","age":20};
console.log(obj1.name);
console.log(obj1.addr);
console.log(obj1.age);

//es6방식 출력
let {name,age}=obj1;
console.log(name);
console.log(age);

let f1=({name,addr})=>{
    console.log("이름"+name);
    console.log("주소"+addr);
}

//호출
f1(obj1);