package xyz.csga.entity;

public class Update {
    private Integer update_id;
    private Message message;
    private Message edited_message;
    private Message channel_post;
    private Message edited_channel_post;
    private InlineQuery inline_Query;
    private ChosenInlineResult chosen_inline_result;
    private CallbackQuery callback_query;
    private ShippingQuery shipping_query;
    private PreCheckoutQuery pre_checkout_query;

    public Integer getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(Integer update_id) {
        this.update_id = update_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getEdited_message() {
        return edited_message;
    }

    public void setEdited_message(Message edited_message) {
        this.edited_message = edited_message;
    }

    public Message getChannel_post() {
        return channel_post;
    }

    public void setChannel_post(Message channel_post) {
        this.channel_post = channel_post;
    }

    public Message getEdited_channel_post() {
        return edited_channel_post;
    }

    public void setEdited_channel_post(Message edited_channel_post) {
        this.edited_channel_post = edited_channel_post;
    }

    public InlineQuery getInline_Query() {
        return inline_Query;
    }

    public void setInline_Query(InlineQuery inline_Query) {
        this.inline_Query = inline_Query;
    }

    public ChosenInlineResult getChosen_inline_result() {
        return chosen_inline_result;
    }

    public void setChosen_inline_result(ChosenInlineResult chosen_inline_result) {
        this.chosen_inline_result = chosen_inline_result;
    }

    public CallbackQuery getCallback_query() {
        return callback_query;
    }

    public void setCallback_query(CallbackQuery callback_query) {
        this.callback_query = callback_query;
    }

    public ShippingQuery getShipping_query() {
        return shipping_query;
    }

    public void setShipping_query(ShippingQuery shipping_query) {
        this.shipping_query = shipping_query;
    }

    public PreCheckoutQuery getPre_checkout_query() {
        return pre_checkout_query;
    }

    public void setPre_checkout_query(PreCheckoutQuery pre_checkout_query) {
        this.pre_checkout_query = pre_checkout_query;
    }
}
