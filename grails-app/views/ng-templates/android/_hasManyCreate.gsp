
<g:set var="AndroidSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>

<div class="control-group" data-ng-class="{error: errors.${AndroidSubPrefix}os}">
    <label class="control-label" for="${AndroidSubPrefix}os">Os</label>
    <div class="controls">
        <input type="text" id="os" name="os" data-ng-model="${AndroidSubPrefix}os">

        <span class="help-inline" data-ng-show="errors.${AndroidSubPrefix}os">{{errors.${AndroidSubPrefix}os}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />

<div class="control-group" data-ng-class="{error: errors.${AndroidSubPrefix}ui}">
    <label class="control-label" for="${AndroidSubPrefix}ui">Ui</label>
    <div class="controls">
        <input type="text" id="ui" name="ui" data-ng-model="${AndroidSubPrefix}ui">

        <span class="help-inline" data-ng-show="errors.${AndroidSubPrefix}ui">{{errors.${AndroidSubPrefix}ui}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />


