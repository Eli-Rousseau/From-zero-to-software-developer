const objects = [
    "the Force",
    "your training",
    "the dark side",
    "great power",
    "the Jedi way",
    "a great disturbance",
    "your destiny",
    "the future",
    "the Sith",
    "the light side",
    "your path",
    "the galaxy",
    "the truth",
    "wisdom",
    "patience",
    "the balance",
    "the mission",
    "the council",
    "a challenge",
    "the Force's will"
];

const mainVerbs = [
    "learn",
    "face",
    "sense",
    "master",
    "trust",
    "seek",
    "confront",
    "embrace",
    "understand",
    "overcome",
    "defeat",
    "control",
    "follow",
    "discover",
    "rely on",
    "ignore",
    "choose",
    "resist",
    "balance",
    "unite"
];

const subjects = [
    "you",
    "I",
    "we",
    "a Jedi",
    "the apprentice",
    "the master",
    "they",
    "the council",
    "a Sith",
    "the chosen one",
    "the Force",
    "the enemy",
    "the path",
    "the mission",
    "your mind",
    "the truth",
    "the darkness",
    "the light",
    "the young one",
    "destiny"
];

const auxiliaryVerbs = [
    "must",
    "will",
    "can",
    "should",
    "could",
    "would",
    "shall",
    "may",
    "might",
    "ought to",
    "have to",
    "need to",
    "shall not",
    "must not",
    "cannot",
    "will not",
    "may not",
    "should not",
    "ought not",
    "would not"
];

function getRandomElement(arr) {
    return arr[Math.round(Math.random() * arr.length - 1)];
}

function setFirstCharUpperCase(str) {
    return str[0].toUpperCase() + str.substr(1, str.length - 1);
}

function generateYodishSentence() {
    const object = getRandomElement(objects);
    const mainVerb = getRandomElement(mainVerbs);
    const subject = getRandomElement(subjects);
    const auxiliaryVerb = getRandomElement(auxiliaryVerbs);
    
    // Construct the Yodish sentence
    const yodishSentence = `Yoda speaks: "${setFirstCharUpperCase(mainVerb)} ${object}, ${subject} ${auxiliaryVerb}."`;
    return yodishSentence;
}

// Generate a Yodish sentence
console.log(generateYodishSentence());
