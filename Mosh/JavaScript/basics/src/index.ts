function findingNemo(ocean: string[]) {
    for (var i = 0; i < ocean.length; i++) {
        var fish = ocean[i];
        if (fish === "Nemo")
            return `Nemo is at position ${--i}`;
    }
}
var ocean: string[] = ["shark", "wale", "octopus", "Nemo", "dolphin"];
console.log(findingNemo(ocean));
