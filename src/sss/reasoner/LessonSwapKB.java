package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Schedule;

/**
 * Rule base used to swap lessons.
 */
  class Jeops_RuleBase_LessonSwapKB extends jeops.AbstractRuleBase {

  
    /**
     * Identifiers of rule lessonSwap1
     */
    private String[] identifiers_lessonSwap1 = {
        "lesson",
        "lesson2",
        "schedule"
    };

    /**
     * Returns the identifiers declared in rule lessonSwap1
     *
     * @return the identifiers declared in rule lessonSwap1
     */
    private String[] getDeclaredIdentifiers_lessonSwap1() {
         return identifiers_lessonSwap1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule lessonSwap1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_lessonSwap1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Schedule";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule lessonSwap1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_lessonSwap1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Schedule.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule lessonSwap1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_lessonSwap1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
        }
    }

    /**
     * Returns an object declared in the rule lessonSwap1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_lessonSwap1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Lesson_2;
            case 2: return sss_scheduler_objects_Schedule_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule lessonSwap1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_lessonSwap1() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Lesson_2,
                            sss_scheduler_objects_Schedule_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule lessonSwap1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_lessonSwap1(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[2];
    }

    /**
     * Condition 0 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatableLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatableLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>schedule.containsAllocatedLesson(lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsAllocatedLesson(sss_scheduler_objects_Lesson_2));
    }

    /**
     * Checks whether some conditions of rule lessonSwap1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond(int index) {
        switch (index) {
            case 0: return lessonSwap1_cond_0();
            case 1: return lessonSwap1_cond_1();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule lessonSwap1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_lessonSwap1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
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
    private boolean checkCondForDeclaration_lessonSwap1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!lessonSwap1_cond_0()) return false;
                if (!lessonSwap1_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule lessonSwap1
     */
    private void lessonSwap1() {
      System.out.println("lessonSwap1 fired");
      modified(sss_scheduler_objects_Schedule_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "lessonSwap1"
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
        3
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
            case 0: return lessonSwap1_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_lessonSwap1(declIndex);
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
            case 0: return checkCondForDeclaration_lessonSwap1(declIndex);
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
            case 0: return getDeclaredClassName_lessonSwap1(declIndex);
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
            case 0: return getDeclaredClass_lessonSwap1(declIndex);
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
            case 0: lessonSwap1(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 1;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_lessonSwap1();
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
            case 0: setObject_lessonSwap1(declIndex, value); break;
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
            case 0: return getObject_lessonSwap1(declIndex);
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
            case 0: return getObjects_lessonSwap1();
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
            case 0: setObjects_lessonSwap1(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_2;
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_LessonSwapKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file LessonSwapKB.rules
 *
 * @version Jan 7, 2014
 */
public class LessonSwapKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public LessonSwapKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public LessonSwapKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_LessonSwapKB(this);
    }

}
