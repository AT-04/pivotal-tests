package org.fundacionjala.pivotal.pages.story;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.fundacionjala.pivotal.pages.Steps;

/**
 * Created by pivotal-test Team.
 */
public final class StoryStrategyLambda {

    /**
     * Private constructor for the Project Strategy Lambda utility class.
     */
    private StoryStrategyLambda() {
    }

    /**
     * This method performs the strategy pattern whit lambda.
     *
     * @param attributesMap This variable contains the attributes of Story.
     * @param storyBoard    This variable contains story Page Object.
     */
    public static void strategy(Map<StoryAttributes, String> attributesMap,
                                StoryBoard storyBoard) {
        Map<StoryAttributes, Steps> strategyOption = strategySetAttributes(attributesMap, storyBoard);
        Set<StoryAttributes> attributes = attributesMap.keySet();
        attributes.forEach((attributeItem) -> strategyOption.get(attributeItem).executeStep());
    }

    /**
     * This method performs the strategy pattern whit lambda.
     *
     * @param attributesMap This variable contains the attributes of story.
     * @param storyBoard    This variable contains story Page Object.
     * @return The strategy map.
     */
    private static Map<StoryAttributes, Steps> strategySetAttributes(
            Map<StoryAttributes, String> attributesMap, StoryBoard storyBoard) {

        Map<StoryAttributes, Steps> strategyMap = new HashMap<>();

        strategyMap.put(StoryAttributes.STORY_NAME,
                () -> storyBoard.setNameInputField(attributesMap.get(StoryAttributes.STORY_NAME)));
        strategyMap.put(StoryAttributes.STORY_TYPE,
                () -> storyBoard.setStoryType(StoryTypes.valueOf(attributesMap.get(StoryAttributes.STORY_TYPE))));
        strategyMap.put(StoryAttributes.STORY_POINTS,
                () -> storyBoard.setStoryPoints(StoryPoints.valueOf(attributesMap.get(StoryAttributes.STORY_POINTS))));
        strategyMap.put(StoryAttributes.STORY_BLOCKERS,
                () -> storyBoard.setStoryBlockers(attributesMap.get(StoryAttributes.STORY_BLOCKERS)));
        strategyMap.put(StoryAttributes.STORY_DESCRIPTION,
                () -> storyBoard.setStoryDescription(attributesMap.get(StoryAttributes.STORY_DESCRIPTION)));
        strategyMap.put(StoryAttributes.STORY_LABEL,
                () -> storyBoard.setStoryLabel(attributesMap.get(StoryAttributes.STORY_LABEL)));
        return strategyMap;
    }
}
