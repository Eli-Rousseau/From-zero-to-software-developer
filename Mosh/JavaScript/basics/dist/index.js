"use strict";
function findingNemo(ocean) {
    for (var i = 0; i < ocean.length; i++) {
        var fish = ocean[i];
        if (fish === "Nemo")
            return `Nemo is at position ${--i}`;
    }
}
var ocean = ["shark", "wale", "octopus", "Nemo", "dolphin"];
console.log(findingNemo(ocean));
//# sourceMappingURL=index.js.map