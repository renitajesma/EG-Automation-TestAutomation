package folderAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
public class RemoveJSONField {
	
	public static void main(String[] args) throws IOException {
        File jsonFile = new File("\\WBG\\Automation\\DataAnalytics\\DataAnalytics-Test-Automation\\src\\main\\java\\convertJson2Pojo\\sample\\input.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNode root = mapper.readTree(jsonFile);

       
       // JsonCleaner jsonCleaner = new JsonCleaner(root, (node) -> node.isNumber() && node.numberValue().intValue() == -1);
        JsonCleaner jsonCleaner = new JsonCleaner(root, (node) -> node.asText()=="odata.context");
        JsonNode result = jsonCleaner.removeAll();

        // write to file
        mapper.writeValue(System.out, result);
    }
}

class JsonCleaner {

    private final JsonNode root;
    private final Predicate<JsonNode> toRemoveCondition;

    JsonCleaner(JsonNode node, Predicate<JsonNode> toRemoveCondition) {
        this.root = Objects.requireNonNull(node);
        this.toRemoveCondition = Objects.requireNonNull(toRemoveCondition);
    }

    public JsonNode removeAll() {
        process(root);
        return root;
    }

    private void process(JsonNode node) {
        if (node.isObject()) {
            ObjectNode object = (ObjectNode) node;
            Iterator<Map.Entry<String, JsonNode>> fields = object.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                JsonNode valueToCheck = field.getValue();
                if (valueToCheck.isContainerNode()) {
                    process(valueToCheck);
                } else if (toRemoveCondition.test(valueToCheck)) {
                    fields.remove();
                }
            }
        } else if (node.isArray()) {
            ArrayNode array = (ArrayNode) node;
            array.elements().forEachRemaining(this::process);
        }
    }
}


