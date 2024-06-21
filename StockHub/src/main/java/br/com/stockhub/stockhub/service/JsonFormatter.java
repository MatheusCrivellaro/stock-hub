package br.com.stockhub.stockhub.service;

import org.springframework.stereotype.Service;

@Service
public class JsonFormatter {

    public String formatter(String json) {
        return json.replace("\\\"", "\"");
    }

    public String style(String json) {

        json = formatter(json);
        StringBuilder formattedJSON = new StringBuilder();
        String indentString = "";
        boolean inQuote = false;

        for (int i = 0; i < json.length(); i++) {
            char charFromJson = json.charAt(i);
            switch (charFromJson) {
                case '\"':
                    formattedJSON.append(charFromJson);
                    if (!inQuote) {
                        inQuote = true;
                    } else if (i > 0 && json.charAt(i - 1) != '\\') {
                        inQuote = false;
                    }
                    break;
                case '{':
                case '[':
                    formattedJSON.append(charFromJson);
                    if (!inQuote) {
                        formattedJSON.append("\n");
                        indentString = increaseIndent(indentString);
                        formattedJSON.append(indentString);
                    }
                    break;
                case '}':
                case ']':
                    if (!inQuote) {
                        formattedJSON.append("\n");
                        indentString = decreaseIndent(indentString);
                        formattedJSON.append(indentString);
                    }
                    formattedJSON.append(charFromJson);
                    break;
                case ',':
                    formattedJSON.append(charFromJson);
                    if (!inQuote) {
                        formattedJSON.append("\n");
                        formattedJSON.append(indentString);
                    }
                    break;
                case ':':
                    formattedJSON.append(charFromJson);
                    if (!inQuote) {
                        formattedJSON.append(" ");
                    }
                    break;
                default:
                    formattedJSON.append(charFromJson);
            }
        }

        return formattedJSON.toString();
    }

    private String increaseIndent(String indent) {
        return indent + "    ";
    }

    private String decreaseIndent(String indent) {
        return indent.substring(0, indent.length() - 4);
    }
}

