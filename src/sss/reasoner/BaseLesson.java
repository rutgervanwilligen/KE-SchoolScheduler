package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Weekday;

/**
 * Rule base used to select lessons.
 */
  class Jeops_RuleBase_BaseLesson extends jeops.AbstractRuleBase {

  
    /**
     * Identifiers of rule lessonSelection1
     */
    private String[] identifiers_lessonSelection1 = {
        "lesson"
    };

    /**
     * Returns the identifiers declared in rule lessonSelection1
     *
     * @return the identifiers declared in rule lessonSelection1
     */
    private String[] getDeclaredIdentifiers_lessonSelection1() {
         return identifiers_lessonSelection1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule lessonSelection1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_lessonSelection1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule lessonSelection1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_lessonSelection1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule lessonSelection1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_lessonSelection1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule lessonSelection1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_lessonSelection1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule lessonSelection1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_lessonSelection1() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule lessonSelection1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_lessonSelection1(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
    }

    /**
     * Condition 0 of rule lessonSelection1.<p>
     * The original expression was:<br>
     * <code>lesson.getSubject().getCode().equals("LO")</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection1_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getSubject().getCode().equals("LO"));
    }

    /**
     * Condition 1 of rule lessonSelection1.<p>
     * The original expression was:<br>
     * <code>lesson.getRanking() == 0</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection1_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getRanking() == 0);
    }

    /**
     * Checks whether some conditions of rule lessonSelection1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection1_cond(int index) {
        switch (index) {
            case 0: return lessonSelection1_cond_0();
            case 1: return lessonSelection1_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule lessonSelection1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_lessonSelection1(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!lessonSelection1_cond_0()) return false;
                if (!lessonSelection1_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_lessonSelection1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule lessonSelection1
     */
    private void lessonSelection1() {
      sss_scheduler_objects_Lesson_1.setRanking((sss_scheduler_objects_Lesson_1.getRanking()) + 10);
      modified(sss_scheduler_objects_Lesson_1);
      }


  
  
    /**
     * Identifiers of rule lessonSelection2
     */
    private String[] identifiers_lessonSelection2 = {
        "lesson"
    };

    /**
     * Returns the identifiers declared in rule lessonSelection2
     *
     * @return the identifiers declared in rule lessonSelection2
     */
    private String[] getDeclaredIdentifiers_lessonSelection2() {
         return identifiers_lessonSelection2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule lessonSelection2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_lessonSelection2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule lessonSelection2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_lessonSelection2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule lessonSelection2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_lessonSelection2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule lessonSelection2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_lessonSelection2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule lessonSelection2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_lessonSelection2() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule lessonSelection2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_lessonSelection2(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
    }

    /**
     * Condition 0 of rule lessonSelection2.<p>
     * The original expression was:<br>
     * <code>lesson.getSubject().getCode().equals("HA")</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection2_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getSubject().getCode().equals("HA"));
    }

    /**
     * Condition 1 of rule lessonSelection2.<p>
     * The original expression was:<br>
     * <code>lesson.getRanking() == 0</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection2_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getRanking() == 0);
    }

    /**
     * Checks whether some conditions of rule lessonSelection2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSelection2_cond(int index) {
        switch (index) {
            case 0: return lessonSelection2_cond_0();
            case 1: return lessonSelection2_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule lessonSelection2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_lessonSelection2(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!lessonSelection2_cond_0()) return false;
                if (!lessonSelection2_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_lessonSelection2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule lessonSelection2
     */
    private void lessonSelection2() {
      sss_scheduler_objects_Lesson_1.setRanking((sss_scheduler_objects_Lesson_1.getRanking()) + 5);
      modified(sss_scheduler_objects_Lesson_1);
      }




    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "lessonSelection1",
        "lessonSelection2"
    };

    /**
     * Returns the name of the rules in this class file.
     *
     * @return the name of the rules in this class file.
     */
    public String[] getRuleNames() {
        return File_ruleNames;
    }

    /**
     * The number of declarations of the rules in this class file.
     */
    private static final int[] File_numberOfDeclarations = {
        1,
        1
    };

    /**
     * Returns the number of declarations of the rules in this class file.
     *
     * @return the number of declarations  of the rules in this class file.
     */
    public int[] getNumberOfDeclarations() {
        return File_numberOfDeclarations;
    }

    /**
     * The number of conditions of the rules in this class file.
     */
    private static final int[] File_numberOfConditions = {
        2,
        2
    };

    /**
     * Returns the number of conditions of the rules in this class file.
     *
     * @return the number of conditions  of the rules in this class file.
     */
    public int[] getNumberOfConditions() {
        return File_numberOfConditions;
    }

    /**
     * Checks whether a condition of some rule is satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param condIndex the index of the condition to be checked
     * @return <code>true</code> if the corresponding condition for the
     *          given rule is satisfied. <code>false</code> otherwise.
     */
    public boolean checkCondition(int ruleIndex, int condIndex) {
        switch (ruleIndex) {
            case 0: return lessonSelection1_cond(condIndex);
            case 1: return lessonSelection2_cond(condIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of some rule that depend only on
     * the given object are satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          the given rule are satisfied;
     *           <code>false</code> otherwise.
     */
    public boolean checkConditionsOnlyOf(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkConditionsOnlyOf_lessonSelection1(declIndex);
            case 1: return checkConditionsOnlyOf_lessonSelection2(declIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference only the elements declared up to the given index
     * are true.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all the conditions of a rule which
     *          reference only the elements declared up to the given index
     *          are satisfied; <code>false</code> otherwise.
     */
    public boolean checkCondForDeclaration(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkCondForDeclaration_lessonSelection1(declIndex);
            case 1: return checkCondForDeclaration_lessonSelection2(declIndex);
            default: return false;
        }
    }

    /**
     * Returns the class name of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class name of the declared object.
     */
    public String getDeclaredClassName(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClassName_lessonSelection1(declIndex);
            case 1: return getDeclaredClassName_lessonSelection2(declIndex);
            default: return null;
        }
    }

    /**
     * Returns the class of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class of the declared object.
     */
    public Class getDeclaredClass(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClass_lessonSelection1(declIndex);
            case 1: return getDeclaredClass_lessonSelection2(declIndex);
            default: return null;
        }
    }

    /**
     * Fires one of the rules in this rule base.
     *
     * @param ruleIndex the index of the rule to be fired
     */
    protected void internalFireRule(int ruleIndex) {
        switch (ruleIndex) {
            case 0: lessonSelection1(); break;
            case 1: lessonSelection2(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 2;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_lessonSelection1();
            case 1: return getDeclaredIdentifiers_lessonSelection2();
            default: return new String[0];
        }
    }

    /**
     * Sets an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @param value the value of the object being set.
     */
    public void setObject(int ruleIndex, int declIndex, Object value) {
        switch (ruleIndex) {
            case 0: setObject_lessonSelection1(declIndex, value); break;
            case 1: setObject_lessonSelection2(declIndex, value); break;
        }
    }

    /**
     * Returns an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @return the value of the corresponding object.
     */
    public Object getObject(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getObject_lessonSelection1(declIndex);
            case 1: return getObject_lessonSelection2(declIndex);
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @return an object array of the variables bound to the
     *          declarations of some rule.
     */
    public Object[] getObjects(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getObjects_lessonSelection1();
            case 1: return getObjects_lessonSelection2();
            default: return null;
        }
    }
    /**
     * Defines all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @param objects an object array of the variables bound to the
     *          declarations of some rule.
     */
    public void setObjects(int ruleIndex, Object[] objects) {
        switch (ruleIndex) {
            case 0: setObjects_lessonSelection1(objects); break;
            case 1: setObjects_lessonSelection2(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_BaseLesson(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file BaseLesson.rules
 *
 * @version Dec 27, 2013
 */
public class BaseLesson extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public BaseLesson(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public BaseLesson() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_BaseLesson(this);
    }

}
