//map반복문
let array=['red','green','blue','pink','ornage','gray'];
//출력
array.map((color,idx)=>console.log((idx+1)+":"+color));

console.log("====================================");

// //배열 데이터 잘라내기 - slice
// //blue삭제후 출력
// array=[...array.slice(0,2), /*0-1*/
//         ...array.slice(3,array.length)]; /*3-마지막*/
// array.map((color,idx)=>console.log((idx+1)+":"+color));

// console.log("====================================");

//배열 데이터 걸러내기 - filter
let array2=array.filter((color,idx)=>idx!==2);
array2.map((color,idx)=>console.log((idx+1)+":"+color));