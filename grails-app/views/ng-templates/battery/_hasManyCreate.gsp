
<g:set var="BatterySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>

<div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}standByTime}">
    <label class="control-label" for="${BatterySubPrefix}standByTime">Stand By Time</label>
    <div class="controls">
        <input type="text" id="standByTime" name="standByTime" data-ng-model="${BatterySubPrefix}standByTime">

        <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}standByTime">{{errors.${BatterySubPrefix}standByTime}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />

<div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}talkTime}">
    <label class="control-label" for="${BatterySubPrefix}talkTime">Talk Time</label>
    <div class="controls">
        <input type="text" id="talkTime" name="talkTime" data-ng-model="${BatterySubPrefix}talkTime">

        <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}talkTime">{{errors.${BatterySubPrefix}talkTime}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />

<div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}type}">
    <label class="control-label" for="${BatterySubPrefix}type">Type</label>
    <div class="controls">
        <input type="text" id="type" name="type" data-ng-model="${BatterySubPrefix}type">

        <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}type">{{errors.${BatterySubPrefix}type}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />


