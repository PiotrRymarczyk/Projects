package piotrek.nauka.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestClassGetSet.class
//	ClassGetSet_isFirstChar.class,
//	ClassGetSet_nothingTestes.class,
//	ClassGetSet_isLetterIncludedIgnoreCase_String_Positive.class,
//	ClassGetSet_isLetterIncludedIgnoreCase_char_Positive.class,
//	ClassGetSet_isLetterIncludedIgnoreCase_String_Negative.class,
//	ClassGetSet_isLetterIncludedIgnoreCase_char_Negative.class,
//	ClassGetSet_isLetterIncludedCaseSensitive_char.class,
//	ClassGetSet_isLetterIncludedCaseSensitive_String.class
})

public class AllTests {
}
