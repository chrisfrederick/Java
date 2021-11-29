const balanceIndex = arr => {
    if(arr.length < 3){
        return -1;
    }
    for(let i = 1; i < arr.length-1; i++){
        let leftSum=0;
        let rightSum=0;
        for(let j=0; j < i; j++){
            leftSum+=arr[j];
        }
        for(let j=i+1; j< arr.length; j++){
            rightSum+=arr[j];
        }
        if(leftSum === rightSum){
            return i;
        }
    }
    return -1;
}

console.log(balanceIndex([-2, 5, 7, 0, 3])); // 2
console.log(balanceIndex([9, 9])); // -1

const balancePoint = arr => {
    if(arr.length < 2) {
        return false;
    }
    for(let i = 0; i < arr.length-1; i++){
        let leftSum=0;
        let rightSum=0;
        for(let j=0; j <= i; j++){
            leftSum+=arr[j];
        }
        for(let j=i+1; j< arr.length; j++){
            rightSum+=arr[j];
        }
        if(leftSum === rightSum){
            return true;
        }
    }
    return false;
}

console.log(balancePoint([4,3,7,4,10])); // true
console.log(balancePoint([4,3,7,4,11,2])); // false