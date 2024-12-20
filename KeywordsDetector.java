public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        for (int i=0; i<keywords.length;i++){
            keywords[i] = MyString.lowerCase(keywords[i]);
        }
        detectAndPrint(sentences, keywords);
    }
 
    // Iterates through all the sentences.
    // If a sentence contains one or more of the keywords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String [] tempStrings = new String [sentences.length];
        for (int i=0; i<sentences.length;i++){
            tempStrings[i]=sentences[i];
        }
        for(int i=0;i<sentences.length;i++){ // takes a sentence
            String currentSentence = MyString.lowerCase(tempStrings[i]); // lower case the sentence
            for (int j=0;j<keywords.length;j++) {
            String currentWord = keywords[j];
            if (currentSentence.indexOf(currentWord) != -1){
                System.out.println(sentences[i]);
            }
            }
        }
    }
}
