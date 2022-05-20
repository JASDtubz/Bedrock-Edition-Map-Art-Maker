/*
    Copyright Loshun Ltd. 2022
    Updated Friday, May 20
    Version 0.9
*/

function findChunk()
{
    let x = parseInt(document.getElementById("x").value);
    let z = parseInt(document.getElementById("z").value);
    
    if (isNaN(x) || isNaN(z)) { return; }
    
    let x0 = (x / 16) * 16;
    let x1 = x0 + 127;
    let z0 = (z / 16) * 16;
    let z1 = z0 + 127;
    
    document.getElementById("nw").textContent = "Northwest: ( " + x0 + " , " + z0 + " )";
    document.getElementById("ne").textContent = "Northeast: ( " + x1 + " , " + z0 + " )";
    document.getElementById("sw").textContent = "Southwest: ( " + x0 + " , " + z1 + " )";
    document.getElementById("se").textContent = "Southeast: ( " + x1 + " , " + z1 + " )";
}
